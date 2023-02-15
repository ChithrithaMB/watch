package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.WatchRepo;
import com.example.demo.watch.Watch;

@RestController
public class WatchController {


	@Autowired
	private WatchRepo watchRepo;
	
	@GetMapping("/getAllWatches")
	public ResponseEntity<List<Watch>> getAllWatches()
	{
		try
		{
			List<Watch>WatchList = new ArrayList<>();
			watchRepo.findAll().forEach(WatchList::add);
			if(WatchList.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(WatchList, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getWatchById/{id}")
	public ResponseEntity<Watch> getWatchById(@PathVariable Long id)
	{
		try
		{
			Optional<Watch>WatchData=watchRepo.findById(id);
			if(WatchData.isPresent())
			{
				return new ResponseEntity<>(WatchData.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping("/addWatch")
	public ResponseEntity<Watch> addWatch(@RequestBody Watch watch)
	{
		try
		{
			Watch watchobj = watchRepo.save(watch);
			return new ResponseEntity<>(watchobj, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@PutMapping("/updateWatchbyId/{id}")
	public ResponseEntity<Watch> updateWatchbyId(@PathVariable Long id,@RequestBody Watch newWatchData)
	{
		try
		{
			Optional<Watch>oldWatchData=watchRepo.findById(id);
			if(oldWatchData.isPresent())
			{
				Watch updateWatch = oldWatchData.get();
				updateWatch.setBrand(newWatchData.getBrand());
				updateWatch.setCost(newWatchData.getCost());
				updateWatch.setInstock(newWatchData.getInstock());
				Watch watchobj = watchRepo.save(updateWatch);
				return new ResponseEntity<>(watchobj, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/deleteWatchbyId/{id}")
	public ResponseEntity<HttpStatus> DeleteWatchbyId(@PathVariable Long id)
	{
		try
		{
			watchRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteWatchbyId")
	public ResponseEntity<HttpStatus> DeleteWatch()
	{
		try
		{
			watchRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}