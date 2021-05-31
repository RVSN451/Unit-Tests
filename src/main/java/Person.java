import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person implements Serializable {
    private static Integer personCount = 0;

    private final Integer personID;
    private final String name;
    private final String family;
    private final LocalDate dateOfBirth;
    private final Sex sex;
    private final Education education;

    public Person(String name, String family, LocalDate dateOfBirth, Sex sex, Education education) {
        this.personID = ++personCount;
        this.name = name;
        this.family = family;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.education = education;

    }

    public static Integer getPersonCount() {
        return personCount;
    }

    public Integer getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person that = (Person) o;

        if (personID != that.personID) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        int result = personID != null ? name.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "ID: " + this.personID + ";\n\t\tимя: " + this.family + " " + this.name + "." +
                "\n\t\tПол: " + this.sex.rusSex +
                ". Возраст: " + ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now()) + " (" + dateOfBirth + ")" +
                "\n\t\tОбразование: " + this.education.rusEducation + ".";
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String family;
        LocalDate dateOfBirth;
        private Sex sex;
        private Education education;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFamily(String family) {
            this.family = family;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setSex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Builder setEducation(Education education) {
            this.education = education;
            return this;
        }

        public Person buildPerson() {
            return new Person(name, family, dateOfBirth, sex, education);
        }
    }
}

