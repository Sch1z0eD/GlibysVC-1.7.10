package net.gliby.voicechat.client.device;

import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import java.io.UnsupportedEncodingException;

public class Device {

	private TargetDataLine line;
	private Mixer.Info info;

	public Device(TargetDataLine line, Mixer.Info info) {
		this.line = line;
		this.info = info;
	}

	public String getDescription() {
		return info.getDescription();
	}

	public String getIdentifer() {
		return info.getName();
	}

	public Mixer.Info getInfo() {
		return info;
	}

	public TargetDataLine getLine() {
		return line;
	}

	public String getName() {
		try {
			return this.info.getName() != null ? new String(info.getName().getBytes("Windows-1252"), "Windows-1251") : "none";
		} catch (UnsupportedEncodingException e) {
			return this.info.getName() != null ? this.info.getName() : "none";
		}
	}

	public String getVendor() {
		return info.getVendor();
	}

	public String getVersion() {
		return info.getVersion();
	}

	public void setDevice(Device device) {
		this.line = device.line;
		this.info = device.info;
	}
}
