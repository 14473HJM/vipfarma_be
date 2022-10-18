package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @PostMapping("/offers")
    public ResponseEntity<Offer> create(@RequestBody Offer offer) {
        offer = offerService.create(offer);
        return ResponseEntity.created(null).body(offer);
    }

    @GetMapping("/offers")
    public ResponseEntity<List<Offer>> getAll() {
        List<Offer> offerList = offerService.getAll();
        return ResponseEntity.ok(offerList);
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<Offer> getById(@PathVariable Long id) {
        Offer offer = offerService.getById(id);
        return ResponseEntity.ok(offer);
    }

    @GetMapping("/offers/{id}/stock")
    public ResponseEntity<Offer> getOfferStock(@PathVariable Long id) {
        Offer offer = offerService.getById(id);
        return ResponseEntity.ok(offer);
    }

    @GetMapping("/offers/stock")
    public ResponseEntity<List<OfferStock>> getAllWithStock() {
        List<OfferStock> offerList = offerService.getAllOffersWithStock();
        return ResponseEntity.ok(offerList);
    }
}
