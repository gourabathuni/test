package br.com.rlabs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestApi {

	@GetMapping("/")
    public String getQuestions() {
        return "Hello World";
    }
}
