package dao;

import java.util.List;

import entities.CommandeFr;

public interface ICommandeFrDao {
	public CommandeFr save(CommandeFr CmD);
	public List<CommandeFr> CommandeFrAll();
	public CommandeFr getCommandeFr(int id);
	public CommandeFr update(CommandeFr CmD);
	public void deleteCommandeFr(int id);


}
