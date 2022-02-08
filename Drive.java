package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Drive {
    // talons on left side
    public TalonFX talonL1 = new TalonFX(Constants.idL1);
    public TalonFX talonL2 = new TalonFX(Constants.idL2);

    // talons on right side
    public TalonFX talonR1 = new TalonFX(Constants.idR1);
    public TalonFX talonR2 = new TalonFX(Constants.idR2);

    public Drive() {
        // L2 follows L1
        talonL2.set(ControlMode.Follower, Constants.idL1);

        // R2 follows R1
        talonR2.set(ControlMode.Follower, Constants.idR1);
    }

    public void stop() {

        talonL1.set(ControlMode.PercentOutput, 0);
        talonR1.set(ControlMode.PercentOutput, 0);

    }

    public void setOpenLoop(double throttle, double turn) {

        // negative turn value means right, positive turn value means left
        // negative throttle value means backward, positive throttle value means forward
      if (throttle > 0) {
          talonL1.set(ControlMode.PercentOutput, (-throttle + turn)/2);
          talonR1.set(ControlMode.PercentOutput, (throttle + turn)/2);
      } else if (throttle == 0) {
          talonL1.set(ControlMode.PercentOutput, 0);
          talonR1.set(ControlMode.PercentOutput, 0);
      } else if (throttle < 0) {
          talonL1.set(ControlMode.PercentOutput, (throttle + turn)/2);
          talonR1.set(ControlMode.PercentOutput, (-throttle + turn)/2);
      }
    }
}