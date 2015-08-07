package tillerino.tillerinobot.lang;

import java.util.List;
import java.util.Random;

import org.tillerino.osuApiModel.Mods;
import org.tillerino.osuApiModel.OsuApiUser;

import tillerino.tillerinobot.BeatmapMeta;
import tillerino.tillerinobot.IRCBot.IRCBotUser;
import tillerino.tillerinobot.RecommendationsManager.Recommendation;

/**
 * TRANSLATION NOTE:
 * 
 * Please put some contact data into the following tag. If any additional
 * messages are required, I'll use the English version in all translations and
 * notify the authors.
 * Translator Email: markshi233@163.com
 * @author Tillerino tillmann.gaida@gmail.com https://github.com/Tillerino https://osu.ppy.sh/u/2070907
 */
public class Default implements Language {

	@Override
	public String unknownBeatmap() {
		return "抱歉，我不认识这个图。它有可能太新了,太难了，未排名，或者不在标准的osu模式里。";
	}

	@Override
	public String internalException(String marker) {
		return "呃... 看来Tillerino本人把我的线路搞乱了。"
				+ "如果他还没有注意到问题的话，可以麻烦[https://github.com/Tillerino/Tillerinobot/wiki/Contact 通知他吗]? (reference "
				+ marker + ")";
	}

	@Override
	public String externalException(String marker) {
		return "发生什么了？ Osu服务端只给我发来乱码. 你知道这是什么意思吗？ 0011101001010000"
				+ "Tillerino本人说并不用担心，再试一遍吧。"
				+ "如果你有什么原因很担心的话，你可以[https://github.com/Tillerino/Tillerinobot/wiki/Contact 联系他]。 (reference "
				+ marker + ")";
	}

	@Override
	public String noInformationForModsShort() {
		return "没有要求的模组的信息";
	}

	@Override
	public void welcomeUser(IRCBotUser user, OsuApiUser apiUser, long inactiveTime) {
		if (inactiveTime < 60 * 1000) {
			user.message("哔哔~");
		} else if (inactiveTime < 24 * 60 * 60 * 1000) {
			user.message("欢迎回来， " + apiUser.getUserName() + ".");
		} else if (inactiveTime > 7l * 24 * 60 * 60 * 1000) {
			user.message(apiUser.getUserName() + "...");
			user.message("。。。是你吗？好久不见了！");
			user.message("你回来可真好。我可以给你一些推荐吗？");
		} else {
			String[] messages = {
					"你看起来想要一个推荐",
					"真高兴见到你！ :)",
					"你是我最喜欢的人类。 (别告诉其他的人类!)",
					"真是一个惊喜！ ^.^",
					"我就指望你出现呢。其他的人类都太无聊了，不过别告诉他们！ :3",
					"今天想做什么呢？",
			};

			Random random = new Random();

			String message = messages[random.nextInt(messages.length)];

			user.message(apiUser.getUserName() + "，" + message);
		}
	}

	@Override
	public String unknownCommand(String command) {
		return "Unknown command \"" + command
				+ "\". 如果需要帮忙的话请输入!help";
	}

	@Override
	public String noInformationForMods() {
		return "对不起，我现在没有该模组的信息";
	}

	@Override
	public String malformattedMods(String mods) {
		return "这些模组看起来不太对。模组的组合可以是DT HR HD HT EZ NC FL SO NF。请不要用空格或者特殊符号把他们合在一起。比如：!with HDHR, !with DTEZ";
	}

	@Override
	public String noLastSongInfo() {
		return "我不记得我给了你歌曲信息了啊。。。";
	}

	@Override
	public String tryWithMods() {
		return "试试开着一些模组玩这个图！";
	}

	@Override
	public String tryWithMods(List<Mods> mods) {
		return "试试带着这些模组" + Mods.toShortNamesContinuous(mods) + "玩吧!";
	}

	/**
	 * The user's IRC nick name could not be resolved to an osu user id. The
	 * message should suggest to contact @Tillerinobot or /u/Tillerino.
	 * 
	 * @param exceptionMarker
	 *            a marker to reference the created log entry. six or eight
	 *            characters.
	 * @param name
	 *            the irc nick which could not be resolved
	 * @return
	 */
	public String unresolvableName(String exceptionMarker, String name) {
		return "你的名字让我很困惑。你被禁了吗？如果你没有的话，请 [https://github.com/Tillerino/Tillerinobot/wiki/Contact 联系Tillerino]. (reference "
				+ exceptionMarker + ")";
	}

	@Override
	public String excuseForError() {
		return "对不起，我被一串漂亮的零和一打扰了。你要啥来着？";
	}

	@Override
	public String complaint() {
		return "你的投诉已经被发送。Tillerino会在有时间的时候检查问题。";
	}

	@Override
	public void hug(final IRCBotUser user, OsuApiUser apiUser) {
		user.message("来一发吧！");
		user.action("抱抱" + apiUser.getUserName());
	}

	@Override
	public String help() {
		return "你好！我是杀死了Tillerino然后偷走了他的账号的机器人！开个玩笑，我只是借他的帐号用而已。"
				+ " [https://twitter.com/Tillerinobot 状态与更新]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki 命令]"
				+ " - [http://ppaddict.tillerino.org/ ppaddict]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki/Contact 联系]";
	}

	@Override
	public String faq() {
		return "[https://github.com/Tillerino/Tillerinobot/wiki/FAQ 常见问题]";
	}

	@Override
	public String featureRankRestricted(String feature, int minRank, OsuApiUser user) {
		return "对不起，目前" + feature + " 只对排名超过" + minRank + "的玩家开放。";
	}

	@Override
	public String mixedNomodAndMods() {
		return "无模组加上模组是几个意思？";
	}

	@Override
	public String outOfRecommendations() {
		return "我已经推荐了所有我能够想到的图。"
				+ "试试其他的推荐或者输入!reset. 如果你不清楚的话，请输入 !help.";
	}

	@Override
	public String notRanked() {
		return "这个图好像没有排名。";
	}

	@Override
	public void optionalCommentOnNP(IRCBotUser user,
			OsuApiUser apiUser, BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnWith(IRCBotUser user, OsuApiUser apiUser,
			BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnRecommendation(IRCBotUser user,
			OsuApiUser apiUser, Recommendation meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public boolean isChanged() {
		return false;
	}

	@Override
	public void setChanged(boolean changed) {

	}

	@Override
	public String invalidAccuracy(String acc) {
		return "无效的精准度： \"" + acc + "\"";
	}

	@Override
	public void optionalCommentOnLanguage(IRCBotUser user, OsuApiUser apiUser) {
		/*
		 * TRANSLATION NOTE: This line is sent to the user right after they have
		 * chosen this Language implementation. The English version refers to
		 * itself as the default version ("just the way I am"), so translating
		 * the English message doesn't make any sense.
		 * 
		 * Instead, we've been using the line
		 * "*Translator* helped me learn *Language*." in translations. Replace
		 * *Translator* with your osu name and *Language* with the name of the
		 * language that you are translating to, and translate the line into the
		 * new language. This serves two purposes: It shows that the language
		 * was changed and gives credit to the translator.
		 * 
		 * You don't need to use the line above, and you don't have have to give
		 * yourself credit, but you should show that the language has changed.
		 * For example, in the German translation, I just used the line
		 * "Nichts leichter als das!", which translates literally to
		 * "Nothing easier than that!", which refers to German being my first
		 * language.
		 * 
		 * Tillerino
		 * 
		 * P.S. you can put a link to your profile into the line like this:
		 * [https://osu.ppy.sh/u/2070907 Tillerino]
		 */
		user.message("壮哉我大天朝！-SporeBread");
	}

	@Override
	public String invalidChoice(String invalid, String choices) {
		return "对不起，但是 \"" + invalid
				+ "\"无效。 请试试： " + choices + "!";
	}

	@Override
	public String setFormat() {
		return "设置参量的格式为！set 选项 数值。如果需要更多指示的话请输入!help。";
	}
}
