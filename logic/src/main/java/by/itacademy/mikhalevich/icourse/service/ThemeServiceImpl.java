package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.ThemeService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Theme;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

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
    public Optional<Theme> updateTheme(Theme theme) {
        themeRepository.save(theme);
        return null;
    }

    @Override
    public Optional<Theme> createTheme(Theme theme) {
        return null;
    }

    @Override
    public Optional<Theme> deleteTheme(Integer id) {
        return null;
    }

    @Override
    public Optional<Theme> getThemeById(Integer id) {
        Optional<Theme> theme = themeRepository.find(id);
        if (theme.isPresent()) {
            return theme;
        } else {
            log.error("Theme id: "+ id +" not exists");
            return Optional.of(new Theme());
        }
    }
}
