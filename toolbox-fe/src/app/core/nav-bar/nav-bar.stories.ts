import { Meta, moduleMetadata, Story } from '@storybook/angular';
import { MatButtonModule } from '@angular/material/button';

import { NavBarComponent } from './nav-bar.component';

export default {
  component: NavBarComponent,
  title: 'Home Page/NavBar',
  excludeStories: /.*Data$/,
  decorators: [
    moduleMetadata({
      imports: [MatButtonModule]
    })
  ]
} as Meta;

const Template: Story = (args) => ({
  props: {
    ...args
  }
});

export const Default = Template.bind({});
Default.args = {
  loggedIn: false
};

export const LoggedIn = Template.bind({});
LoggedIn.args = {
  loggedIn: true
};
