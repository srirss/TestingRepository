package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DemoController { no usages & Roadstar

@GetMapping("/remove")
public ResponseEntity<String> remove (@RequestParam String input) {

if (input.length() < 2) {
return ResponseEntity.badRequest().build();.
}
if (input.length() == 2) {
return ResponseEntity.ok("");
}
return ResponseEntity.ok(
input.substring(1, input.length() - 1)
); 
}
}
