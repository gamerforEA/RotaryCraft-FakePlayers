/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.TileEntities.Weaponry;

import net.minecraft.world.World;
import Reika.RotaryCraft.Base.TileEntity.TileEntityPowerReceiver;
import Reika.RotaryCraft.Registry.MachineRegistry;

public class TileEntitySelfDestruct extends TileEntityPowerReceiver
{
	private boolean lastHasPower;

	@Override
	protected void animateWithTick(World world, int x, int y, int z)
	{
	}

	@Override
	public MachineRegistry getMachine()
	{
		return MachineRegistry.SELFDESTRUCT;
	}

	@Override
	public void updateEntity(World world, int x, int y, int z, int meta)
	{
		super.updateTileEntity();
		this.getSummativeSidedPower();
		boolean hasPower = power > 0;
		if (lastHasPower && !hasPower) this.destroy(world, x, y, z);
		else lastHasPower = hasPower;
	}

	@Override
	public boolean hasModelTransparency()
	{
		return false;
	}

	@Override
	public int getRedstoneOverride()
	{
		return 0;
	}

	public void destroy(World world, int x, int y, int z)
	{
		/* TODO gamerforEA code replace:
		if (!world.isRemote)
		{
			tickcount++;
			int n = 6;
			int count = 32;
			double rx = x + 0.5 + rand.nextInt(2 * n + 1) - n;
			double ry = y + 0.5 + rand.nextInt(2 * n + 1) - n;
			double rz = z + 0.5 + rand.nextInt(2 * n + 1) - n;
			int irx = MathHelper.floor_double(rx);
			int iry = MathHelper.floor_double(ry);
			int irz = MathHelper.floor_double(rz);
			if (ReikaPlayerAPI.playerCanBreakAt((WorldServer) worldObj, irx, iry, irz, this.getServerPlacer())) world.createExplosion(null, rx, ry, rz, 3F, true);
			for (int i = 0; i < 32; i++)
				world.spawnParticle("lava", rx + rand.nextInt(7) - 3, ry + rand.nextInt(7) - 3, rz + rand.nextInt(7) - 3, 0, 0, 0);
			if (tickcount > count)
			{
				world.newExplosion(null, x + 0.5, y + 0.5, z + 0.5, 12F, true, true);
				ReikaWorldHelper.temperatureEnvironment(world, x, y, z, 1000);
			}
			MachineRegistry m = this.getMachine();
			MachineRegistry m2 = MachineRegistry.getMachine(world, x, y, z);
			if (m != m2 && tickcount <= count)
			{
				world.setBlock(x, y, z, m.getBlock(), m.getMachineMetadata(), 3);
				TileEntitySelfDestruct te = (TileEntitySelfDestruct) world.getTileEntity(x, y, z);
				te.lastHasPower = true;
				te.tickcount = tickcount;
			}
		} */
		this.delete();
		// TODO gamerforEA code end
	}
}