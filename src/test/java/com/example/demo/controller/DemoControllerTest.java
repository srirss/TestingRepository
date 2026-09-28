package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.params.provider.ValueSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest 
@AutoConfigureMockMvc
class DemoControllerTest {

@Autowired
private MockMvc mockMvc;

@ParameterizedTest new
@CsvSource({
"eloquent, loquen", "country, ountr", "person, erso", "xyz, y"
})

void shouldRemoveFirstAndLastCharacter (String input, String expected)
throws Exception {
mockMvc.perform(get("/remove")
.param("input", input))
.andExpect(status().is0k())
.andExpect(content().string(expected));
}

@ParameterizedTest new
@CsvSource({
"ab, ' '",
"12, ' '"
})

void shouldReturnEmptyStringForTwoCharacterStrings (String input,
String expected)
throws Exception {
mockMvc.perform(get("/remove")
.param("input", input))
.andExpect(status().isok())
andExpect(content().string(expected));
}

@ParameterizedTest 
@ValueSource(strings = {"", "a"})
void shouldReturnBadRequestForStrings ShorterThanTwoCharacters(String input)
throws Exception {
mockMvc.perform(get("/remove")
.param("input", input))
.andExpect(status().isBadRequest());
}

@ParameterizedTest
@CsvSource({
"123%qwerty+', '23%qwerty'",
"'@hello#', 'hello'"
})

void shouldHandle NumbersAndSpecialCharacters (String input,String expected)
throws Exception {

mockMvc.perform(get("/remove")
.param("input", input))
.andExpect(status().isok())
.andExpect(content().string(expected));
}
}
