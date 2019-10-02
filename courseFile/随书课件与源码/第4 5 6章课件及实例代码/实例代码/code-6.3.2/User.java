public class User implements Serializable{
private String firstname;
private String lastname;
private int age;
public int getAge() {
return age;
}
public void setAge(int age) {
this.age = age;
}
public String getFirstname() {
return firstname;
}
public void setFirstname(String firstname) {
this.firstname = firstname;
}
public String getLastname() {
return lastname;
}
public void setLastname(String lastname) {
this.lastname = lastname;
}
public boolean equals(Object obj){
if(!(obj instanceof User)){
return false;
}else{
User user = (User)obj;
return new EqualsBuilder().appendSuper(super.equals(obj))
.append(this.firstname, user.firstname)
.append(this.lastname, user.lastname)
.isEquals();
}
}
public int hashCode(){
return new HashCodeBuilder(-528253723, -475504089)
.appendSuper(super.hashCode())
.append(this.firstname)
.append(this.lastname)
.toHashCode();
}
}
