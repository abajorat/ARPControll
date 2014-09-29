package views;

import javax.swing.JPanel;

import models.Device;

public class DeviceView extends JPanel {
    
    Device device;
    public DeviceView(Device d){
	this.device = d;
    }
}
