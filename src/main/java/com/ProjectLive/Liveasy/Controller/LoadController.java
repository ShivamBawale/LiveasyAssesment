package com.ProjectLive.Liveasy.Controller;

import com.ProjectLive.Liveasy.Entity.Load;
import com.ProjectLive.Liveasy.Service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    // POST: Create a new Load
    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        loadService.saveLoad(load);
        return new ResponseEntity<>("Load details added successfully", HttpStatus.CREATED);
    }

    // GET: Get Loads by Shipper ID
    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
        UUID shipperUUID = UUID.fromString(shipperId);
        System.out.println("Received Shipper ID: " + shipperUUID);
        List<Load> loads = loadService.getLoadsByShipperId(shipperUUID);

        if (loads.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // No loads found
        }
        return new ResponseEntity<>(loads, HttpStatus.OK);  // Loads found
    }

    // GET: Get Load by Load ID
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        Load load = loadService.getLoadById(loadId);

        if (load != null) {
            return new ResponseEntity<>(load, HttpStatus.OK);  // Load found
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Load not found
        }
    }

    // PUT: Update Load
    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable UUID loadId, @RequestBody Load load) {
        Load updatedLoad = loadService.updateLoad(loadId, load);

        if (updatedLoad != null) {
            return new ResponseEntity<>("Load updated successfully", HttpStatus.OK);  // Update successful
        } else {
            return new ResponseEntity<>("Load not found", HttpStatus.NOT_FOUND);  // Load not found
        }
    }

    // DELETE: Delete Load by Load ID
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable UUID loadId) {
        boolean isDeleted = loadService.deleteLoad(loadId);

        if (isDeleted) {
            return new ResponseEntity<>("Load deleted successfully", HttpStatus.OK);  // Deletion successful
        } else {
            return new ResponseEntity<>("Load not found", HttpStatus.NOT_FOUND);  // Load not found
        }
    }
}
