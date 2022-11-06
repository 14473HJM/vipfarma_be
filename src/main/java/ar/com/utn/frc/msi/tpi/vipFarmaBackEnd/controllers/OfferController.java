package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.OfferStock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("/stocks/offers")
    public ResponseEntity<List<OfferStock>> getAllWithStock(@RequestParam(required = false) Long branchOfficeId,
                                                            @RequestParam(required = false) Long productId) {
        List<OfferStock> offerList;
        if(productId == null && branchOfficeId == null) {
            offerList = offerService.getAllOffersWithStock();
        } else if(productId != null && branchOfficeId == null) {
            offerList = offerService.getOfferStockByProductId(productId);
        } else if(productId != null && branchOfficeId != null) {
            offerList = offerService.getOfferStockByProductIdAndBranchOffice(productId, branchOfficeId);
        } else {
            offerList = offerService.getOfferStockByBranchOffice(branchOfficeId);
        }
        return ResponseEntity.ok(offerList);
    }

    @GetMapping("/stock/offer")
    public ResponseEntity<OfferStock> getOfferByParameters(@RequestParam Long branchOfficeId,
                                                           @RequestParam Long productId,
                                                           @RequestParam(required = false) Long planId) {
        OfferStock offer = offerService
                .getOfferStockByProductIdAndBranchOfficeAndPlanId(productId, branchOfficeId, planId);
        return ResponseEntity.ok(offer);
    }
}
