package com.example.springboot.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.model.Photo;
import com.example.springboot.service.PhotoService;

@RestController
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	
	@GetMapping("/photos/{id}")
	public String getPhoto(@PathVariable String id, Model model) {
	    Photo photo = photoService.getPhoto(id);
	    model.addAttribute("title", photo.getTitle());
	    model.addAttribute("image", 
	      Base64.getEncoder().encodeToString(photo.getImage().getData()));
	    return "photos";
	}
	
	@PostMapping("/photos/add")
	public String addPhoto(@RequestParam("title") String title, 
	  @RequestParam("image") MultipartFile image, Model model) 
	  throws IOException {
		System.out.println("what???");
	    String id = photoService.addPhoto(title, image);
		System.out.println("what???");
	    return "redirect:/photos/" + id;
	}

}
