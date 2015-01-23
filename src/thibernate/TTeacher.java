package thibernate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_teacher database table.
 * 
 */
@Entity
@Table(name="t_teacher")
@NamedQuery(name="TTeacher.findAll", query="SELECT t FROM TTeacher t")
public class TTeacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int age;

	private String name;

	//bi-directional many-to-one association to TStudent
	@OneToMany(mappedBy="TTeacher")
	private List<TStudent> TStudents;

	public TTeacher() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TStudent> getTStudents() {
		return this.TStudents;
	}

	public void setTStudents(List<TStudent> TStudents) {
		this.TStudents = TStudents;
	}

	public TStudent addTStudent(TStudent TStudent) {
		getTStudents().add(TStudent);
		TStudent.setTTeacher(this);

		return TStudent;
	}

	public TStudent removeTStudent(TStudent TStudent) {
		getTStudents().remove(TStudent);
		TStudent.setTTeacher(null);

		return TStudent;
	}

}