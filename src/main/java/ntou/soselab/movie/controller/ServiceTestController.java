package ntou.soselab.movie.controller;

import ntou.soselab.movie.controller.dto.ServiceTestDTO;
import ntou.soselab.movie.model.Show;
import ntou.soselab.movie.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceTestController {
    @Autowired
    private ShowRepository showRepository;

    @PostMapping("/serviceTest")
    public void serviceTest(@RequestBody ServiceTestDTO serviceTestDTO) {
        if (serviceTestDTO.getState().equals("The show id'5ef2bf0d-6dbf-4de8-a095-93690854da5b' is exist and has 2 more seats")) {
            this.setShow();
        }
    }

    private void setShow() {
        showRepository.save(Show.builder()
                .id("5ef2bf0d-6dbf-4de8-a095-93690854da5b")
                .emptySeat(10)
                .build());
    }
}
