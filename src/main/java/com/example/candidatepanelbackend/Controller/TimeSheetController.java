package com.example.candidatepanelbackend.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.Enum.ResponseStatus;
import com.example.candidatepanelbackend.ResponseModels.TimeSheetModel;
import com.example.candidatepanelbackend.Service.TimeSheetService;
import com.example.candidatepanelbackend.utils.ResponseBean;

@RestController
@RequestMapping("timesheet")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeSheetController {

	Logger logger = LoggerFactory.getLogger(TimeSheetController.class);

	@Autowired
	private TimeSheetService timeSheetService;

	@PostMapping("addOrUpdate")
	ResponseBean addOrUpdate(@RequestBody List<TimeSheetModel> timeSheetModels) {

		List<TimeSheetModel> nonEmptyItems = timeSheetModels.stream().filter(item -> item.getHours() != null)
				.collect(Collectors.toList());

		System.out.println(nonEmptyItems);

		nonEmptyItems.forEach(item -> {
			if (item.getId() != null) {
				timeSheetService.addOrUpdate(item, item.getId());
				return;
			} else {
				timeSheetService.addOrUpdate(item, null);
			}
		});

		return ResponseBean.generateResponse(HttpStatus.CREATED, ResponseStatus.Success, "Time Sheet updated Succesfully");
	}
	
//	@GetMapping("getLastSyncDate/{employeeId}")
//	public ResponseBean getLastSyncDate(@PathVariable Integer employeeId) {
//		logger.info("Fetching last Sync Date Details...");
//		return timeSheetService.getLastSyncDate(employeeId);
//	}

}
