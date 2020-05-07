import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttempTestComponent } from './attemp-test.component';

describe('AttempTestComponent', () => {
  let component: AttempTestComponent;
  let fixture: ComponentFixture<AttempTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttempTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttempTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
