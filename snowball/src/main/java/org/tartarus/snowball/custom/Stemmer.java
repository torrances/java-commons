package org.tartarus.snowball.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.trimc.blogger.commons.exception.BusinessException;

public class Stemmer extends StemmerBase {

	public Stemmer() {}

	public Map<String, Set<String>> cluster(String... tokens) throws BusinessException {
		Map<String, Set<String>> map = new TreeMap<String, Set<String>>();

		for (String token : tokens) {
			String stem = stem(token);
			Set<String> inner = (map.containsKey(stem)) ? map.get(stem) : new TreeSet<String>();
			inner.add(token);
			map.put(stem, inner);
		}

		return map;
	}

	public String stem(String token) throws BusinessException {
		if (null == getStemmer()) throw new BusinessException("Uninstantiated Stemmer Exception");

		getStemmer().setCurrent(token);
		if (!getStemmer().stem()) return token;

		return getStemmer().getCurrent();
	}

	public List<String> stemToList(String... tokens) throws BusinessException {
		if (null == getStemmer()) throw new BusinessException("Uninstantiated Stemmer Exception");

		List<String> set = new ArrayList<String>();
		for (String token : tokens)
			set.add(stem(token));

		return set;
	}

	public Set<String> stemToSet(String... tokens) throws BusinessException {
		if (null == getStemmer()) throw new BusinessException("Uninstantiated Stemmer Exception");

		Set<String> set = new TreeSet<String>();
		for (String token : tokens)
			set.add(stem(token));

		return set;
	}
}
