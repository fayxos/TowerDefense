package Objects;

public enum DefenderType {
	ARCHER("assets/Sprites/Tower defender/Archer/archer_idle.png", 23, 19, 60),
	MAGE("assets/Sprites/Tower defender/Mage/mage_idle.png", 30, 22, 5),;
	
	public final String path;
	public final int width;
	public final int height;	
	public final int yOffset;

	DefenderType(String path, int width, int height, int yOffset) {
		this.path = path;
		this.width = width;
		this.height = height;
		this.yOffset = yOffset;
	}
}
