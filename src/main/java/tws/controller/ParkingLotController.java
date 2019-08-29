package tws.controller;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ParkingLots")
public class ParkingLotController {

    @Autowired
    private ParkingLotMapper ParkingLotMapper;

    @GetMapping("")
    public ResponseEntity<List<ParkingLot>> getAll() {
        return ResponseEntity.ok(ParkingLotMapper.selectAll());
    }

    @PostMapping("")
    public ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot ParkingLot) {
        ParkingLotMapper.insert(ParkingLot);
        return ResponseEntity.created(URI.create("/ParkingLots/" + ParkingLot.getParkingLotID())).body(ParkingLot);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateParkingLot(@RequestBody ParkingLot ParkingLot){
       ParkingLotMapper.updateParkingLot(ParkingLot);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkingLot(@PathVariable("id") String id){
        ParkingLotMapper.deleteParkingLot(id);
    }
}
