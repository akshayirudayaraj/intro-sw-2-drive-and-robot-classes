import WPILibNewCommands.json;

public class Drive {

    int idL1 = 0;
    int idL2 = 1;
    int idR1 = 2;
    int idR2 = 3;

    // talons on left side
    TalonFX talonL1 = new TalonFX(idL1);
    TalonFX talonL2 = new TalonFX(idL2);

    // talons on right side
    TalonFX talonR1 = new TalonFX(idR1);
    TalonFX talonR2 = new TalonFX(idR2);

    Drive(TalonFX talonL1, TalonFX talonL2, TalonFX talonR1, TalonFx talonR2) {

        talonL1 = talonL1;
        talonL2 = talonL2;
        talonR1 = talonR1;
        talonR2 = talonR2;

        // L2 follows L1
        talonL2.set(ControlMode.Follower, idL1);

        // R2 follows R1
        talonR2.set(ControlMode.Follower, idR1);
        
    }

    public void setOpenLoop(double throttle, double turn) {;

        // negative turn value = left, positive turn value = right
        talonL1.set(ControlMode.PercentOutput, throttle * turn);
        talonR1.set(ControlMode.PercentOutput, throttle * -turn);

    }

    public void stop() {

        talonL1.set(ControlMode.PercentOutput, 0);
        talonR1.set(ControlMode.PercentOutput, 0);

    }
}

public class Robot {

    int joystickLId = 1;
    int joystickRId = 2;

    Joystick joystickL = new Joystick(joystickLId);
    Joystick joystickR = new Joystick(joystickRId);

    Robot(Joystick joystickL, Joystick joystickR) {
        joystickL = joystickL;
        joystickR = joystickR;

        Robot Drive;

    }

    public void teleopPeriodic() {
        
        joystickL.getRawAxis(1);
        joystickR.getRawAxis(0);

        setOpenLoop(joystickL, joystickR);

    }

    public void disabledInit() {
        stop();
    }

    public void testInit() {
        stop();
    }

    public void autoInit() {
        stop();
    }
}

public class Main {
    public static void main (String[] args) {
        teleopPeriodic();
    }
}