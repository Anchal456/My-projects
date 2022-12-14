package working;
import javax.ejb.Local;
@Local
public interface NewSessionBeanLocal {
    float add(float x, float y);
    float subtract(float x, float y);
    float multiply(float x, float y);
    float division(float x, float y);
}