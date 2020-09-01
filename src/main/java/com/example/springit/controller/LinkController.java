package com.example.springit.controller;

import com.example.springit.domain.Comment;
import com.example.springit.domain.Link;
import com.example.springit.repository.CommentRepository;
import com.example.springit.service.LinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LinkController {

    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);

    private CommentRepository commentRepository;

    private LinkService linkService;

    public LinkController(CommentRepository commentRepository,LinkService linkService) {
        this.linkService = linkService;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("links", linkService.findAll());
        return "link/list";
    }

    @GetMapping("/link/{id}")
    public String read(@PathVariable Long id, Model model) {
        Optional<Link> link = linkService.findById(id);
        if (link.isPresent()) {
            Link currentLink = link.get();
            model.addAttribute("link", currentLink);
            Comment comment = new Comment();
            comment.setLink(currentLink);
            model.addAttribute("comment", comment);
            model.addAttribute("success", model.containsAttribute("success"));
            return "link/view";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        logger.info("I will delete somethink " + id);
        linkService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link", new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            logger.info("Validation finding during saving link. ");
            model.addAttribute("link", link);
            return "link/submit";
        } else {
            //save the link
            linkService.save(link);
            logger.info("New link saved successfully");
            redirectAttributes.addAttribute("id", link.getId()).addFlashAttribute("success", true);
            return "redirect:/link/{id}";
        }

    }
    @Secured({"ROLE_USER"})
    @PostMapping("/link/comments")
    public String addComment(@Valid Comment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("There was problem adding a new comment.");
        } else {
            commentRepository.save(comment);
            logger.info("The comment has been saved successfully.");
        }
        return "redirect:/link/" + comment.getLink().getId();
    }

}