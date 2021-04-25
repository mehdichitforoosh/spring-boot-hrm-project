package ir.fullstackit.hrm.employee.command.controller;

import ir.fullstackit.common.IdJsonObject;
import ir.fullstackit.hrm.employee.command.command.CreateEmployeeCommand;
import ir.fullstackit.hrm.employee.command.controller.jsons.CreateEmployeeJsonObject;
import ir.fullstackit.hrm.employee.command.service.EmployeeUpdateService;
import ir.fullstackit.hrm.exception.InvalidJsonException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeCommandController {

    private final EmployeeUpdateService employeeUpdateService;

    @Autowired
    public EmployeeCommandController(EmployeeUpdateService employeeUpdateService) {
        this.employeeUpdateService = employeeUpdateService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IdJsonObject> create(@RequestBody CreateEmployeeJsonObject jsonObject) {
        if (!jsonObject.isValid()) {
            throw new InvalidJsonException("Invalid json");
        }
        String id = UUID.randomUUID().toString();
        String creatorId = "";
        DateTime creationDate = DateTime.now(DateTimeZone.UTC);
        CreateEmployeeCommand command = new CreateEmployeeCommand(id, creatorId, creationDate
                , jsonObject.getName(), jsonObject.getPersonnelId(), jsonObject.getJoiningDate()
                , jsonObject.getDepartmentId(), jsonObject.getJobTitleId(), jsonObject.getWorkShiftId()
                , jsonObject.getDescription());
        employeeUpdateService.create(command);
        IdJsonObject idJsonObject = new IdJsonObject(id);
        return new ResponseEntity(idJsonObject, HttpStatus.OK);
    }
}
