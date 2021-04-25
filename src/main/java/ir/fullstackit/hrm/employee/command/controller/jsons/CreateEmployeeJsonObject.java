package ir.fullstackit.hrm.employee.command.controller.jsons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.fullstackit.common.AbstractCreateJsonObject;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEmployeeJsonObject extends AbstractCreateJsonObject {

    private final String name;
    private final String personnelId;
    private final DateTime joiningDate;
    private final String departmentId;
    private final String jobTitleId;
    private final String workShiftId;
    private final String description;

    @JsonCreator
    public CreateEmployeeJsonObject(@JsonProperty(value = "name") String name
            , @JsonProperty(value = "personnelId") String personnelId
            , @JsonProperty(value = "joiningDate") DateTime joiningDate
            , @JsonProperty(value = "departmentId") String departmentId
            , @JsonProperty(value = "jobTitleId") String jobTitleId
            , @JsonProperty(value = "workShiftId") String workShiftId
            , @JsonProperty(value = "description") String description) {
        System.out.println("const");
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

    @Override
    public boolean isValid() {
        // White list validation
        if (!(!StringUtils.isEmpty(name) && name.length() > 1)) {
            return false;
        }
        if (!(!StringUtils.isEmpty(personnelId))) {
            return false;
        }
        return true;
    }

}
