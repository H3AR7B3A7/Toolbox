import { TestBed } from '@angular/core/testing';
import { expect } from '@jest/globals';

import { TelemetryService } from './telemetry.service';

describe('TelemetryService', () => {
    let service: TelemetryService;

    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(TelemetryService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
