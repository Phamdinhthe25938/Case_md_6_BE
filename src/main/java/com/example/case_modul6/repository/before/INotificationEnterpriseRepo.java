package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Notification.NotificationEnterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotificationEnterpriseRepo extends CrudRepository<NotificationEnterprise,Integer> {

    @Query(nativeQuery = true,value = "select * from notification_enterprise where enterprise_id_enterprise=:id ORDER by time_apply DESC , date_apply DESC")
    List<NotificationEnterprise> notificationEnterpriseSByEnterprise(@Param("id") int id);
}
