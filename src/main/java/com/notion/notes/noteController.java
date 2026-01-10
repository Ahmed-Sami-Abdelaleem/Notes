package com.notion.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class noteController {
@GetMapping("/notes")
public String getNotes() {
    return "Here are your notes!";
}
}
