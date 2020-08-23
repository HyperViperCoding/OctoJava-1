package Cupert.Modules.Movement;
import org.lwjgl.input.Keyboard;

import Cupert.Modules.Modules;
import Cupert.events.event;
import Cupert.events.TYPES.Listeners.EventUpdate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
public class Scaffold extends Modules
{
	//supports the module array in the class modules
public Scaffold() {
	super("Scaffold", "Scaffold", Keyboard.KEY_Z, Categories.PLAYER);
	}

//disable & enable function
	public void onEnable()
	{

		
    
   	 }
	
	
	public void onDisable() 
	{
		
				
	}
	private static boolean cooldown = false;
    public void onEvent(event e) 
    {
    	this.drawAmount();
	
		
        if(e instanceof EventUpdate) 
	     {
		    
		      BlockPos playBlockPos =  new BlockPos(mc.thePlayer.posX, mc.thePlayer.getEntityBoundingBox().minY, mc.thePlayer.posZ);
		      if(mc.theWorld.isAirBlock(playBlockPos.add(0, -1, 0))) {
		    	  if(isValidBlock(playBlockPos.add(0, -2, 0)))
						place(playBlockPos.add(0, -1, 0), EnumFacing.UP);
					else if(isValidBlock(playBlockPos.add(-1, -1, 0)))
						place(playBlockPos.add(0, -1, 0), EnumFacing.EAST);
					else if(isValidBlock(playBlockPos.add(1, -1, 0)))
						place(playBlockPos.add(0, -1, 0), EnumFacing.WEST);
					else if(isValidBlock(playBlockPos.add(0, -1, -1)))
						place(playBlockPos.add(0, -1, 0), EnumFacing.SOUTH);
					else if(isValidBlock(playBlockPos.add(0, -1, 1)))
						place(playBlockPos.add(0, -1, 0), EnumFacing.NORTH);
					else if(isValidBlock(playBlockPos.add(1, -1, 1))) {
						if(isValidBlock(playBlockPos.add(0, -1, 1)))
							place(playBlockPos.add(0, -1, 1), EnumFacing.NORTH);
						place(playBlockPos.add(1, -1, 1), EnumFacing.EAST);
					}else if(isValidBlock(playBlockPos.add(-1, -1, 1))) {
						if(isValidBlock(playBlockPos.add(-1, -1, 0)))
							place(playBlockPos.add(0, -1, 1), EnumFacing.WEST);
						place(playBlockPos.add(-1, -1, 1), EnumFacing.SOUTH);
					}else if(isValidBlock(playBlockPos.add(-1, -1, -1))) {
						if(isValidBlock(playBlockPos.add(0, -1, -1)))
							place(playBlockPos.add(0, -1, 1), EnumFacing.SOUTH);
						place(playBlockPos.add(-1, -1, 1), EnumFacing.WEST);
					}else if(isValidBlock(playBlockPos.add(1, -1, -1))) {
						if(isValidBlock(playBlockPos.add(1, -1, 0)))
							place(playBlockPos.add(1, -1, 0), EnumFacing.EAST);
						place(playBlockPos.add(1, -1, -1), EnumFacing.NORTH);
					}
	      }
	     }
		      }
		 
	 
	
//checking if is is before or after
     
	 

    public void drawAmount() {
        String blocks = String.valueOf(getBlocksAmount());
        ScaledResolution sr = new ScaledResolution(mc);
        mc.fontRendererObj.drawString(blocks,sr.getScaledWidth() / 2 -  mc.fontRendererObj.getStringWidth(blocks) , sr.getScaledHeight()  - 80, 0x00A500);
    }
    private void place(BlockPos pos, EnumFacing face) {
    	
    	cooldown = true;
    	if(face == EnumFacing.UP) {
    		pos = pos.add(0, -1, 0);
    		
    	}else if(face == EnumFacing.NORTH) {
    		pos = pos.add(0 , 0, 1);
    	}else if (face == EnumFacing.EAST) {
    		pos = pos.add(-1, 0, 0);
    		
    	}else if(face == EnumFacing.SOUTH) {
    		pos = pos.add(0 , 0, -1);
    	}else if (face == EnumFacing.WEST) {
    		pos = pos.add(1, 0, 0);
    		
    	}
    	
		
		
    	if((mc.thePlayer.getHeldItem(EnumHand.MAIN_HAND) != null) && (mc.thePlayer.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemBlock)) {
    		
    		
    		mc.thePlayer.swingArm(EnumHand.MAIN_HAND);
    		mc.playerController.processRightClickBlock(mc.thePlayer, mc.theWorld, null, pos, face, new Vec3d(0.5D, 0.5D,  0.5D), EnumHand.MAIN_HAND);
    		double var4 = pos.getX() + 0.25 - mc.thePlayer.posX;
    		double var6 = pos.getZ() + 0.25 - mc.thePlayer.posZ;
    		double var8 = pos.getY() + 0.25 - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
    		double var14= MathHelper.sqrt_double(var4 * var4 + var6*var6);
    		float yaw = (float)(Math.atan2(var6, var4) * 180.0 / 3.141592653489) - 90f;
    		float pitch = (float) -(Math.atan2(var8, var14) * 180.0 /3.141592653489 ) - 90f;
    		int ticks = 0;
    	    ticks ++;
    		if(ticks >= 100) {
    			ticks = 0;
    			
    			mc.thePlayer.connection.sendPacket(new CPacketPlayer.Position(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, mc.thePlayer.onGround));
    		}
    		
    		
    	}
    }
    	private  boolean isValidBlock(BlockPos pos) {
    		Block b = mc.theWorld.getBlockState(pos).getBlock();
    		return !(b instanceof BlockLiquid) && b.getMaterial(null) != Material.AIR;
    		
    	}
    	private int getBlocksAmount() {
            int amount = 0;

            for (int i = 36; i < 45; i++) {
                final ItemStack itemStack = mc.thePlayer.inventoryContainer.getSlot(i).getStack();

                if (itemStack != null && itemStack.getItem() instanceof ItemBlock) {
                    final Block block = ((ItemBlock) itemStack.getItem()).getBlock();
                
                        amount += itemStack.stackSize;
                
            }

            
        }
            return amount;
        }
    }
