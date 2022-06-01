package models;

import lombok.*;


@Getter
@Setter
@ToString // действует на весь класс
@EqualsAndHashCode
@AllArgsConstructor //конструктор со всеми параметрами
@NoArgsConstructor  // без параметров

public class Person1 { // геттеры и сетторы для всех переменных в классе
    /**
     * Age of the person
     *
     * @param age New value for this person's age
     * @return The current value of this person's age
     */

    private int age  = 10;

    /**
     * Name of the person
     *
     * @param age New value for this person's name
     * @return The current value of this person's name
     */

    private String name;

}
