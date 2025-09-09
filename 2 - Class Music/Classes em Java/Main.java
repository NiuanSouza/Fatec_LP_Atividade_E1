package MusicClass;

public class Main {

	public static void main(String[] args) {
		
		Valour valour = new Valour("valour", "lift", "gods");
		valour.liftSouls();

		Honour honour = new Honour("honour", "sing", "songs of praise");
		honour.singPraise();

		Power power = new Power("power", "we're sons", "Mars");
		power.declareLineage();


	}

}
