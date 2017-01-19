package polymorphim3;

public class LgTV implements TV {
	private Speaker speaker;
	public LgTV() {
		System.out.println("===> LgTV ����");
	}
	
	public LgTV(Speaker speaker) {
		System.out.println("===> LgTV ����");
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
