package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Student {
    private String contact;
    private String email;
    private String name;
    private String guardianName;
}
