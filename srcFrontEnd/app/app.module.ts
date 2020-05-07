import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SortPipe } from './sort.pipe';
import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { TestComponent } from './test/test.component';
import { QuestionComponent } from './question/question.component';
import { ShowTestComponent } from './show-test/show-test.component';
import { AttempTestComponent } from './attemp-test/attemp-test.component';
import { ViewQuestionsComponent } from './view-questions/view-questions.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';
import { ViewResultComponent } from './view-result/view-result.component';
import { ViewTestComponent } from './view-test/view-test.component';
import { UpdateTestComponent } from './update-test/update-test.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    SortPipe,
    TestComponent,
    QuestionComponent,
    ShowTestComponent,
    AttempTestComponent,
    ViewQuestionsComponent,
    UpdateQuestionComponent,
    ViewResultComponent,
    ViewTestComponent,
    UpdateTestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
