package by.itacademy.mikhalevich.icourse.impl;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.ThemeService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Theme;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ThemeServiceImpl implements ThemeService {

    public static final int PARAMETER_INDEX = 4;
    private Repository themeRepository;

    public ThemeServiceImpl()  {
        this.themeRepository = RepositoryFactory.getThemeRepository();
    }

    @Override
    public Map<Integer, Theme> readTheme() {
        return themeRepository.findAll();
    }

    @Override
    public Map<Integer, Theme> updateTheme(Theme theme) {
        themeRepository.save(theme);
        return null;
    }

    @Override
    public Map<Integer, Theme> createTheme(Theme theme) {
        return null;
    }

    @Override
    public Map<Integer, Theme> deleteTheme(Integer id) {
        return null;
    }

    @Override
    public Theme getThemeById(Integer id) {
        return null;
    }
}
