describe('Automated Test Suite', () => {
  before(() => {
    // This will run before all the tests in this suite
    cy.visit('https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/');
  });

  it('should verify the title of the URL', () => {
    cy.title().should('eq', 'expected.urlTitle');
  });

  it('should click on Speaking and verify the title of the Page', () => {
    cy.contains('Speaking').click();
    cy.title().should('eq', 'expected.speakingPageTitle');
  });

  it('should verify Keynote Addresses presence and its text', () => {
    cy.contains('Keynote Addresses').should('exist');
    cy.contains('Keynote Addresses').invoke('text').should('include', 'Keynote Addresses');
  });
});


