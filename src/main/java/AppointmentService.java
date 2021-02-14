/*
 * Copyright (c) 2021 Randall Rowland
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
  final private List<Appointment> appointmentList = new ArrayList<>();

  private String newUniqueId() {
    return UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newAppointment() {
    Appointment appt = new Appointment(newUniqueId());
    appointmentList.add(appt);
  }

  public void newAppointment(Date date) {
    Appointment appt = new Appointment(newUniqueId(), date);
    appointmentList.add(appt);
  }

  public void newAppointment(Date date, String description) {
    Appointment appt = new Appointment(newUniqueId(), date, description);
    appointmentList.add(appt);
  }

  public void deleteAppointment(String id) throws Exception {
    appointmentList.remove(searchForAppointment(id));
  }

  protected List<Appointment> getAppointmentList() { return appointmentList; }

  private Appointment searchForAppointment(String id) throws Exception {
    int index = 0;
    while (index < appointmentList.size()) {
      if (id.equals(appointmentList.get(index).getAppointmentId())) {
        return appointmentList.get(index);
      }
      index++;
    }
    throw new Exception("The appointment does not exist!");
  }
}
