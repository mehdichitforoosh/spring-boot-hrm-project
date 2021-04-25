package ir.fullstackit.hrm.employee.command.repository;

import org.joda.time.DateTime;

public interface EmployeeUpdateRepository {

    void create(String id
            , String name
            , String personnelId
            , DateTime joiningDate
            , String departmentId
            , String jobTitleId
            , String workShiftId
            , String description);
}
