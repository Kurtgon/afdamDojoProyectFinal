import { TestBed } from '@angular/core/testing';

import { IsLoguerGuard } from './is-loguer.guard';

describe('IsLoguerGuard', () => {
  let guard: IsLoguerGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(IsLoguerGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
