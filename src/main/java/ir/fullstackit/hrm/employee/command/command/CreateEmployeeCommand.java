package ir.fullstackit.hrm.employee.command.command;

import ir.fullstackit.common.AbstractCreateCommand;
import org.joda.time.DateTime;

public class CreateEmployeeCommand extends AbstractCreateCommand {

    private final String name;
    private final String personnelId;
    private final DateTime joiningDate;
    private final String departmentId;
    private final String jobTitleId;
    private final String workShiftId;
    private final String description;

    public CreateEmployeeCommand(String id, String creatorId, DateTime creationDate, String name, String personnelId, DateTime joiningDate, String departmentId, String jobTitleId, String workShiftId, String description) {
        super(id, creatorId, creationDate);
        this.name = name;
        this.personnelId = personnelId;
        this.joiningDate = joiningDate;
        this.departmentId = departmentId;
        this.jobTitleId = jobTitleId;
        this.workShiftId = workShiftId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPersonnelId() {
        return personnelId;
    }

    public DateTime getJoiningDate() {
        return joiningDate;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getJobTitleId() {
        return jobTitleId;
    }

    public String getWorkShiftId() {
        return workShiftId;
    }

    public String getDescription() {
        return description;
    }
}
