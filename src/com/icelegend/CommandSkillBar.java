package com.icelegend;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandSkillBar implements CommandExecutor {
	final IceLegend ic;
	public CommandSkillBar(IceLegend iceLegend) {
		// TODO Auto-generated constructor stub
		ic = iceLegend;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		// TODO Auto-generated method stub

		if(sender.hasPermission("IceLegend.command.skillbar")) {
			sender.sendMessage(ic.format(Objects.requireNonNull(ic.msg_config.getString("Messages.Command.skillbar"))));
		}
		return true;
	}

}
