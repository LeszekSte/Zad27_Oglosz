package pl.javastart.restoffers.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.model.Offer;
import pl.javastart.restoffers.repository.OfferRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private OfferRepository offerRepository;

    public OfferController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/")
    public List<Offer> getAllOffret() {
        return offerRepository.findAll();
    }

    @GetMapping("/count")
    public int countOffer() {
        List<Offer> offers = offerRepository.findAll();
        return offers.size();
    }

    @GetMapping("/{id}")
    public Offer getOne(@PathVariable Long id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        Offer offer = new Offer();
        if (optionalOffer.isPresent()) {
            offer = optionalOffer.get();
        }
        return offer;
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        if (offerOptional.isPresent()) {
            offerRepository.deleteById(id);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Offer> insert(@RequestBody Offer offer) {
        if (offer.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Offer saveOffer = offerRepository.save(offer);
        return ResponseEntity.ok(saveOffer);
    }
}






