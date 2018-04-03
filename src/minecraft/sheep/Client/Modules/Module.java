package sheep.Client.Modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import sheep.Client.Core;

public class Module {
	
	private Minecraft mc  = Minecraft.getMinecraft();
	protected GuiIngame gui = Minecraft.getMinecraft().ingameGUI;
	public PlayerControllerMP p_controller = Minecraft.getMinecraft().playerController;
	private Core core = Core.INSTANCE;
	
	
	
	private String 			
	MODULE_NAME,KEY_NAME;
	
	private int 			
	KEY_CODE;
	
	private boolean 		
	TOGGLE,RENDER,TICK;
	
	private CATEGORY category;
	
	public enum CATEGORY{
		Render,World,Combat,Player
	}
	
	public Module(String Module_Name, int Key_Code, String Char, CATEGORY cat)
	{
		MODULE_NAME = Module_Name;		KEY_CODE = Key_Code;		KEY_NAME = Char;
		TOGGLE = false;					TICK = false;				RENDER = false;
										category = cat;
	}
	
	public void Toggle()
	{
		TOGGLE = !TOGGLE;
		if(TOGGLE)
			onEnable();
		if(!TOGGLE)
			onDisable();
	}
	
	
	/** HAPPENS WHEN IT GETS ENABLED */
	protected void onEnable()
	{
		core.print("Enabled Module: " + getMODULE_NAME());
	}
	
	/** HAPPENS WHEN IT GETS DISABLED */
	protected void onDisable()
	{
		core.print("Disabled Module: " + getMODULE_NAME());
	}

	
	public void onRender()
	{
		
	}
	
	public void onTick()
	{
		
	}
	
	
	/**GETTERS & SETTERS*/
	
	
	public Minecraft getMc() {
		return mc;
	}

	public void setMc(Minecraft mc) {
		this.mc = mc;
	}

	public GuiIngame getGui() {
		return gui;
	}

	public void setGui(GuiIngame gui) {
		this.gui = gui;
	}

	public Core getCore() {
		return core;
	}

	public void setCore(Core core) {
		this.core = core;
	}

	public String getMODULE_NAME() {
		return MODULE_NAME;
	}

	public void setMODULE_NAME(String mODULE_NAME) {
		MODULE_NAME = mODULE_NAME;
	}

	public String getKEY_NAME() {
		return KEY_NAME;
	}

	public void setKEY_NAME(String kEY_NAME) {
		KEY_NAME = kEY_NAME;
	}

	public int getKEY_CODE() {
		return KEY_CODE;
	}

	public void setKEY_CODE(int kEY_CODE) {
		KEY_CODE = kEY_CODE;
	}

	public boolean isTOGGLE() {
		return TOGGLE;
	}

	public void setTOGGLE(boolean tOGGLE) {
		TOGGLE = tOGGLE;
	}

	public boolean isRENDER() {
		return RENDER;
	}

	public void setRENDER(boolean rENDER) {
		RENDER = rENDER;
	}

	public boolean isTICK() {
		return TICK;
	}

	public void setTICK(boolean tICK) {
		TICK = tICK;
	}

	public CATEGORY getCategory() {
		return category;
	}

	public void setCategory(CATEGORY category) {
		this.category = category;
	}
	
	
}	