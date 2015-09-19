package thibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the t_student database table.
 * 
 */
@Entity
@Table(name="t_student")
@NamedQuery(name="TStudent.findAll", query="SELECT t FROM TStudent t")
public class TStudent implements Serializable {
	private static final long serialVersionUID = 1L;

//	@SequenceGenerator(name="myg",sequenceName="hilo")
	@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "org.hibernate.id.UUIDGenerator")   
	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payablemoney_seq")  
//	@SequenceGenerator(name="payablemoney_seq", sequenceName="id")  
	private String id;

	private int age;

	@Temporal(TemporalType.DATE)
	private Date birth;

	private String name;

	//bi-directional many-to-one association to TTeacher
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private TTeacher TTeacher;

	public TStudent() {
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

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TTeacher getTTeacher() {
		return this.TTeacher;
	}

	public void setTTeacher(TTeacher TTeacher) {
		this.TTeacher = TTeacher;
	}

}