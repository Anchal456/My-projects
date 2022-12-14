package working;
import javax.ejb.Stateless;
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {
    @Override
    public float add(float x, float y) {
        return (x+y);
    }
    @Override
    public float subtract(float x, float y) {
        return (x-y);
    }
    @Override
    public float multiply(float x, float y) {
        return (x*y);
    }
    @Override
    public float division(float x, float y) {
        return (x/y);
    }
}
