package sk.stu.fiit.crs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Data {
    private String name;
    private String surname;
    private String doctor;
    private String date;
    private boolean confirmed;
}
