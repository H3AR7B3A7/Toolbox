# ToolPlatform

## Commands Used to Build Project

### Scaffolding

ng n tool-platform --routing --style scss
ng g m core
ng g m shared
ng g c home
ng g c core/nav-bar

### Material

> ng add @angular/material

### Storybook

> npx storybook init

> yarn add -D @storybook/addon-a11y @storybook/test-runner

### Jest

> ng add @briebug/jest

> yarn add -D jest jest-preset-angular @types/jest @angular-builders/jest

### Remove Karma

> yarn remove karma karma-chrome-launcher karma-coverage-istanbul-reporter karma-jasmine karma-jasmine-html-reporter

### ES Lint & Prettier

> ng add @angular-eslint/schematics

> yarn add -D eslint-plugin-unused-imports prettier eslint-plugin-prettier eslint-config-prettier

### Cypress

> ng add @cypress/schematic
