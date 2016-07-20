package org.openfact.theme;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;

public class JarThemeProvider implements ThemeProvider {

	private Map<Theme.Type, Map<String, ClassLoaderTheme>> themes;

	public JarThemeProvider(Map<Theme.Type, Map<String, ClassLoaderTheme>> themes) {
		this.themes = themes;
	}

	@Override
	public int getProviderPriority() {
		return 0;
	}

	@Override
	public Theme getTheme(String name, Theme.Type type) throws IOException {
		return hasTheme(name, type) ? themes.get(type).get(name) : null;
	}

	@Override
	public Set<String> nameSet(Theme.Type type) {
		if (themes.containsKey(type)) {
			return themes.get(type).keySet();
		} else {
			return Collections.emptySet();
		}
	}

	@Override
	public boolean hasTheme(String name, Theme.Type type) {
		return themes.containsKey(type) && themes.get(type).containsKey(name);
	}

	@Override
	public void close() {
	}

}
